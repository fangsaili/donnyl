/*
 * @Author: your name
 * @Date: 2021-09-15 14:32:48
 * @LastEditTime: 2021-09-15 15:14:19
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /front end/donnyl-manager/src/router/index.js
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

]

const router = createRouter({
    history: createWebHashHistory(),
    routes
})

export default router