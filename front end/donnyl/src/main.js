/*
 * @Author: your name
 * @Date: 2021-09-01 16:40:24
 * @LastEditTime: 2021-09-09 18:11:02
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /front end/donnyl/src/main.js
 */
import { createApp } from 'vue'
import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'
import App from './App.vue'
import router from './router'
import store from './store'
import axios from 'axios'


const app = createApp(App)

// axois.defaults.baseURL = process.env.VUE_APP_SERVER;
// axios.defaults.baseURL = process.env.VUE_APP_SERVER;

// console.log("dev" + process.env.NODE_ENV)

// console.log("prod" + process.env.VUE_APP_SERVER)

app.use(ElementPlus)
app.use(store)
app.use(router)
app.mount('#app')




// createApp(App).use(store).use(router).mount('#app')