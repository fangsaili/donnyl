/*
 * @Author: your name
 * @Date: 2021-09-01 16:40:24
 * @LastEditTime: 2021-09-01 16:51:40
 * @LastEditors: your name
 * @Description: In User Settings Edit
 * @FilePath: /front end/donnyl/src/main.js
 */
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import store from './store'

const app = createApp(App)
app.use(ElementPlus)
app.use(store)
app.use(router)
app.mount('#app')
    // createApp(App).use(store).use(router).mount('#app')