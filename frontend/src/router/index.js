import { createWebHistory, createRouter } from "vue-router";
import Login from '../view/Login';
import Home from '../view/Home';

const routes = [
    {
        path: "/login",
        name: "Login",
        component: Login,
    },
    {
        path: "/",
        name: "Home",
        component: Home,
    },
];

const router = createRouter({
    history: createWebHistory(),
    routes,
});



export default router;