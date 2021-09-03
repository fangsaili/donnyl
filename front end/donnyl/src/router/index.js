/*
 * @Author: your name
 * @Date: 2021-09-01 16:40:24
 * @LastEditTime: 2021-09-03 11:44:39
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/router/index.js
 */
import { createRouter, createWebHashHistory } from 'vue-router'
import Mehome from '../views/index/Home.vue'
const routes = [{
        path: '/',
        name: 'MeHome',
        component: Mehome
    },
    {
        path: '/index/about',
        name: 'Meabout',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/About.vue')
    },
    {
        path: '/index/skills',
        name: 'Meskills',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Skills.vue')
    },
    {
        path: '/index/blog',
        name: 'Meblog',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Blog.vue')
    },
    {
        path: '/index/contact',
        name: 'Mecontact',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Contact.vue')
    },
    {
        path: '/index/education',
        name: 'Meeducation',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Education.vue')
    },
    {
        path: '/index/experience',
        name: 'Meexperience',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Experience.vue')
    },
    {
        path: '/index/portifio',
        name: 'Meportifio',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Portfolio.vue')
    },
    {
        path: '/index/testimonial',
        name: 'Metestimonial',
        component: () =>
            import ( /* webpackChunkName: "about" */ '../views/index/Testimonial.vue')
    },

]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router