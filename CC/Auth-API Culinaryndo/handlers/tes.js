const multer = require('multer');
const uploadImage = require('../helpers/helpers');
const { User } = require ("../models");

module.exports = {
    upload: async (req, res, next) => {
    try {
    const multerMid = multer({
        storage: multer.memoryStorage(),
        limits: {
          fileSize: 5 * 1024 * 1024, // no larger than 5mb.
        },
    });

    if (typeof multerMid.on === 'function') {
        multerMid.on('error', (error, req, res, next) => {
        console.error(error);
            res.status(500).json({
            error: error,
            message: 'Internal server error!',
            });
        });
    }

    multerMid.single('file')(req, res, async (err) => {
        if (err) {
            return next(err);
        }

        const { id }  = req.params;
        const { urlImage } = req.body;

            const findUser = await User.findOne({ where: { id } });

            if (!findUser) {
                return res.status(404).json({
                    status: false,
                    message: "user not found",
                });
            }

            const updated = await User.update(
                {
                    urlImage
                },
                { where: { id } }
            );


        const myFile = req.file;
        const imageUrl = await uploadImage(myFile);

        return res.status(200).json({
            message: 'Photo updated successfully',
            data: {
                imageUrl: imageUrl,
                updated: updated,
            },
        });
    });
    } catch (error) {
        next(error);
    }
    },
};