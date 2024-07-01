import express from 'express'
import { loginUser, getUser, createUser }  from '../controllers/userRestController';
import { authUser } from '../middlewares/authUser';

const apiRouter = express.Router();

// Use Token and Get User Details: GET "api/users/getuser" Login Required
apiRouter.get('/getuser', authUser, getUser)
// Authenticate User and Genrate Token: POST "api/users/login"
apiRouter.post('/login', loginUser)
// Authenticate User and Genrate Token: POST "api/users/register"
apiRouter.post('/register', createUser)

export { apiRouter }