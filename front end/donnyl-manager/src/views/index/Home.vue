<!--
 * @Author: your name
 * @Date: 2021-09-15 15:06:06
 * @LastEditTime: 2021-09-17 11:58:17
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /front end/donnyl-manager/src/views/index/Home.vue
-->
<template>
<div>
    <div style="color:black">
        <el-table :data="tableData" style="width: 120%;line-height:40px">
            <el-table-column prop="id" label="id" width="180"> </el-table-column>
            <el-table-column prop="name" label="name" width="80"> </el-table-column>
            <el-table-column prop="email" label="email" width="140"> </el-table-column>
            <el-table-column prop="subject" label="subject" width="80"> </el-table-column>
            <el-table-column prop="question" label="question"> </el-table-column>

        </el-table>
    </div>
</div>
</template>

<script>
import axios from 'axios'
import {
    ElMessage
} from 'element-plus'
export default {
    data() {
        return {
            tableData: [{
                id: null,
                name: '',
                email: '',
                subject: '',
                question: ''
            }]
        }
    },
    mounted() {
        this.getallcontact();
    },
    methods: {
        getallcontact() {
            axios.get(
                '/contact/all',

            ).then((res) => {
                this.tableData = res.data.content;
                console.log(res);
            }).catch((err) => {
                console.log(err);
                ElMessage.error('error')

            });
        }
    },
}
</script>

<style>
.el-table  {

    color: white;


    --el-table-border-color: #797979;
        --el-table-border: 1px solid #797979 !important;
        --el-border-color-lighter: #797979  !important;


    --el-table-row-hover-background-color: #aaa;
    --el-table-current-row-background-color: #2c2c2c;
    --el-table-header-background-color: #2c2c2c;
    --el-table-fixed-box-shadow: 0 0 10px rgba(0, 0, 0, 0.12);
    --el-table-background-color: #2c2c2c;
    --el-table-tr-background-color: #2c2c2c;
    -el-table-expanded-cell-background-color: #2c2c2c;
}
</style>
