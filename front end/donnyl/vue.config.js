/*
 * @Author: your name
 * @Date: 2021-09-02 11:10:15
 * @LastEditTime: 2021-09-10 10:43:40
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/vue.config.js
 */
module.exports = {
    lintOnSave: true,
    devServer: {
        // open: false,
        // port: 8080,
        // https: false,
        // hotOnly: false,

        proxy: {
            '/api': {
                target: 'https://localhost:8088',
                secure: false,
                ws: true,
                changeOrigin: true,
                pathRewrite: {
                    '^api': ""
                }
            }
        }

    }
}