/*
 * @Author: your name
 * @Date: 2021-09-02 11:10:15
 * @LastEditTime: 2021-09-14 13:47:12
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
                target: 'http://47.97.222.87:8088',
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