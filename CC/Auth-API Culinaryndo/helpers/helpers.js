const util = require('util');
const gc = require('../config');
const bucket = gc.bucket('dfaalt_project');
const { v4: uuidv4 } = require('uuid');

const { format } = util;

/**
 *
 * @param { File } object file object that will be uploaded
 * @description - This function does the following
 * - It uploads a file to the image bucket on Google Cloud
 * - It accepts an object as an argument with the
 *   "originalname" and "buffer" as keys
 */

const uploadImage = (file) =>
	new Promise((resolve, reject) => {
		// Error handling for undefined file
		if (!file || !file.originalname || !file.buffer) {
			reject('File is undefined or missing required properties');
			return;
		}

		const { buffer, mimetype } = file;

		const uniqueFilename = `${uuidv4()}.${mimetype.split('/')[1]}`;

		const blob = bucket.file(uniqueFilename);
		const blobStream = blob.createWriteStream({
			resumable: false,
		});

		blobStream
			.on('finish', () => {
				const publicUrl = format(`https://storage.googleapis.com/${bucket.name}/${blob.name}`);
				resolve(publicUrl);
			})
			.on('error', (err) => {
				reject(`Unable to upload image, something went wrong: ${err.message}`);
			})
			.end(buffer);
	});

module.exports = uploadImage;
