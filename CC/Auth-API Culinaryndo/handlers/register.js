const { User } = require('../models');
const bcrypt = require('bcrypt');

module.exports = {
	register: async (req, res, next) => {
		try {
			const { name, username, email, password } = req.body;

			const findname = await User.findOne({ where: { name } });
			if (findname) {
				return res.status(409).json({
					status: false,
					message: 'name already exist',
					data: null,
				});
			}
			const findEmail = await User.findOne({ where: { email } });
			if (findEmail) {
				return res.status(409).json({
					status: false,
					message: 'user with email already exist',
					data: null,
				});
			}

			const findUser = await User.findOne({ where: { username } });
			if (findUser) {
				return res.status(409).json({
					status: false,
					message: 'username already exist',
					data: null,
				});
			}

			if (password.length < 8) {
				return res.status(400).json({
					status: false,
					message: 'password less than 8 characters',
					data: null,
				});
			}

			const hashedPassword = await bcrypt.hash(password, 10);

			const created = await User.create({
				name,
				username,
				password: hashedPassword,
				email,
			});

			return res.status(201).json({
				status: true,
				message: 'create data user successful',
				data: {
					id: created.id,
					name: created.name,
					username: created.username,
					email: created.email,
				},
			});
		} catch (error) {
			next(error);
		}
	},
};
