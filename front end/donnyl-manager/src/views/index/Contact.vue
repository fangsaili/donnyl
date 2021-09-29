<!--
 * @Author: your name
 * @Date: 2021-09-03 11:37:45
 * @LastEditTime: 2021-09-28 12:20:51
 * @LastEditors: Please set LastEditors
 * @Description: In User Settings Edit
 * @FilePath: /donnyl/src/views/index/Contact.vue
-->
<template>
<div>
    <div class="contact" id="sss">
        <div class="contact-header">
            <div class="contact-title">
                <span class="contact-img"></span>
                <span class="contact-contact"> Contact Me</span>
            </div>
            <div class="contact-title-content">I'm Fangsai Li. I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li.I'm Fangsai Li. </div>
        </div>
        <div class="contact-content">
            <div class="contact-details">
                <div class="dt-phone">
                    <div>Phone</div>
                    <div><span>Mobile</span><span>:&nbsp&nbsp&nbsp&nbsp +86 19512102264</span></div>
                    <div><span>QQ</span><span>:&nbsp&nbsp&nbsp&nbsp 1340710624</span></div>
                </div>
                <div class="dt-email">
                    <div>Email</div>
                    <div><span>1340710624@qq.com</span></div>
                    <div><span>k1814426@kcl.ac.uk</span></div>
                </div>
                <div class="dt-address">
                    <div>Address</div>
                    <div><span style="width:100%">Hubei Ezhou,Yanglanguojikangc-31, China</span></div>
                    <div><a class="maplink" @click="tomap">https://j.map.baidu.com/ef/oSVJ</a></div>
                </div>

            </div>
            <div class="contact-me">
                <div class="contact-me-title">HIRE ME</div>
                <input v-model="form.name" type="text" placeholder="Your Name">
                <input v-model="form.email" type="text" placeholder="Your Email">
                <input v-model="form.subject" type="text" placeholder="Subject">
                <!-- <text v-model="form.question" type="text" placeholder="Your Question?"> -->
                <textarea v-model="form.question" name="" id="" rows="10" placeholder="Your Question?"></textarea>
                <button class="submit" @click="submitform()"><span></span> Send</button>
            </div>
        </div>
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
            name: "",
            form: {
                name: "",
                email: "",
                subject: "",
                question: ""
            }

        }
    },
    methods: {
        tomap() {
            window.open("https://j.map.baidu.com/ef/oSVJ")

        },
        submitform() {
            if (this.form.question == "") {
                return ElMessage.error({
                    message: 'Not filling in the question',

                })

                

            }
            if (this.form.question.length < 50) {

                    console.log(this.form.question.length)
                    return ElMessage.error({
                        message: 'The question is too short, with at least 50 letters in length',

                    })

                }

            axios.post(
                '/contact/update', JSON.stringify(this.form)

            ).then((res) => {
                if(res.data.success==true){
                    ElMessage.success({
                    message: 'Successfully sent,Thank you for your suggestion!',
                    type: 'success',
                })
                }else{
                    if(res.data.message=="timelimit"){
                    ElMessage.error({
                    message: 'A maximum of 10 messages are sent each day',
                    type: 'error',
                })
                }
                }
                
                console.log(res);
            }).catch((err) => {
                ElMessage.error('Error,network error')
                console.log(res);
            });

        }
    },

}
</script>

<style>
@import url("../css/contact.css");
</style>
