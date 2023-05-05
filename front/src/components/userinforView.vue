<template>
    <div class="userinfo_body">
        <div v-if=!userinfor.isonline class="userinfo_nore">
            <ul>
                <li>您还未登陆</li>
                <li><a href="/#/login">点我登陆</a></li>
            </ul>
        </div>

        <div v-else class="userinfo_ison">
            <ul>
                <li>id:{{ userinfor.id }}</li>
                <li>用户名：{{ userinfor.userName }}</li>
                <li>性别：{{ userinfor.gender }}</li>
                <li>年龄：{{ userinfor.age }}</li>
                <li>电话号码：{{ userinfor.userNumber }}</li>
                <li>地址：{{ userinfor.userAddress }}</li>
                <li>标签1:{{ userInterests.userInterest11 }}  {{ userInterests.userInterest12 }}  {{ userInterests.userInterest13 }}</li>
                <li>标签2:{{ userInterests.userInterest21 }}  {{ userInterests.userInterest22 }}  {{ userInterests.userInterest23 }}</li>
                <li>标签3:{{ userInterests.userInterest31 }}  {{ userInterests.userInterest32 }}  {{ userInterests.userInterest33 }}</li>
            </ul>
        </div>
    </div>
</template>

<script>
import { computed } from 'vue';
import { useStore } from 'vuex'
import axios from 'axios';
export default {

    data(){
        const stores=useStore();
        const userinfor = computed(() => stores.state.user.userinfo);
        const userInterests=computed(()=> stores.getters['UserInterest/getuserInterests'])
        return{
            stores,
            userinfor,
            userInterests,
        }
    },
    mounted:async function(){
        setTimeout(async ()=>{
            await axios.post('http://localhost:8080/GetByUid',{
                uid:this.stores.state.user.userinfo.id,
            }).then((result)=>{
                this.stores.commit('UserInterest/setuserInterests',result.data);
            }).catch((error)=>{
                console.log(error)
            })
        },1000)
    },
    methods:{
        
    }
}
</script>

<style lang="less" scoped>
.userinfo_body{
    position: sticky;
    left: 10px;
    top: 10px;

    .userinfo_nore{
        ul{
            li{
                height: 100px;
                display: flex;
                align-items: center;
                justify-content: flex-start;
                padding-left: 20px;
                color: red;
                font-size: 30px;

                a{
                    font-size: 20px;
                    text-align: center;
                }
            }
        }
    }

    .userinfo_ison{
        ul{
            li{
                margin-top: 10px;
            }
        }
    }
}
</style>