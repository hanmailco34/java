import { createWebHistory, createRouter } from "vue-router";
import Login from '../view/Login';
import Home from '../view/Home';
import Join from '../view/Join';

const routes = [
    {
        path: "/login",
        name: "Login",
        component: Login,
    },
    {
        path: "/join",
        name: "Join",
        component: Join,
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