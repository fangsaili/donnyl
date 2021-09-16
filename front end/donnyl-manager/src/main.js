/*
 * @Author: your name
 * @Date: 2021-09-15 14:32:48
 * @LastEditTime: 2021-09-16 09:56:33
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /front end/donnyl-manager/src/main.js
 */
import { createApp } from "vue";
import ElementPlus from "element-plus";
import "element-plus/dist/index.css";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import axios from "axios";

axios.defaults.baseURL = process.env.VUE_APP_SERVER;
axios.defaults.timeout = 8000;
axios.defaults.headers = {
    accept: "application/json",
    "Content-Type": "application/json",
};

axios.interceptors.request.use(
    (config) => {
        if (sessionStorage.getItem("token")) {
            config.headers["token"] = sessionStorage.getItem("token");
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

console.log("env : " + process.env.NODE_ENV);

console.log("prod : " + process.env.VUE_APP_SERVER);

console.log(axios.defaults.baseURL);

const app = createApp(App);

app.use(ElementPlus);
app.use(store);
app.use(router);

app.mount("#app");