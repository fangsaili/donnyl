<!--
 * @Author: your name
 * @Date: 2021-09-03 11:37:45
 * @LastEditTime: 2021-09-09 18:44:59
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
                    <div><span>Mob.</span><span>:&nbsp&nbsp&nbsp&nbsp +86 19512102264</span></div>
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
                <div class="contact-me-title">HIRE ME{{form.name}}</div>
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

            axios.post(
                'http://47.97.222.87:8088/contact/update', JSON.stringify(this.form), {
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }

            ).then((res) => {
                console.log(res);
            }).catch((err) => {
                console.log(res);
            });

        }
    },

}
</script>

<style>
@import url("../css/contact.css");
</style>
