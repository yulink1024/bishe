<template>
  <div class="loginbox">
    <el-card class="LoginForm">
      <template #header> <h3 class="headertext">用户登陆</h3> </template>
      <div>
        <el-form-item label="账号:">
          <el-input v-model="loginForm.loginName" placeholder="请输入注册时的电话号码" />
        </el-form-item>
        <el-form-item label="密码:">
          <el-input v-model="loginForm.password" placeholder="请输入密码" type="password"/>
        </el-form-item>
        <div class="tobtn">
          <el-button type="success" class="lobtn" @click="Loginon">登陆</el-button>
          <el-button type="success" class="lobtn" @click="toRegister">注册</el-button>
        </div>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import axios from "axios";
import { ElMessage } from "element-plus";
import { reactive } from "vue";
import { useRouter } from "vue-router";
import { useStore } from "vuex";
const loginForm = reactive({
  loginName: "",
  password: ""
});

const stores=useStore();
const Loginon = () => {
  axios.post('http://localhost:8080/Login',
  {
    userNumber:loginForm.loginName,
    userPassword:loginForm.password
  }).then((res)=>{
    if(res.data){
      ElMessage({
        message: "登陆成功",
        type: "success"
      });
      axios.post('http://localhost:8080/set',{
        userNumber:loginForm.loginName
      }).then((res)=>{
        console.log(res.data)
        stores.commit('user/setUserinfo',res.data)
        stores.commit('user/setIsonline')
        axios.post('http://localhost:8080/GetByUid',{
            uid:res.data.id,
        }).then((resu)=>{
            stores.commit('UserInterest/setuserInterests',resu.data);
        }).catch((error)=>{
            console.log(error)
        })
      }).catch((error)=>{
        console.log(error);
      });

      router.push('/')
    }else{
      ElMessage({
        message: "用户名或密码错误，请重试",
        type:'error'
      })
    }
  }).catch((error)=>{
    console.log(error);
  })
  
};
const router=useRouter()
const toRegister=()=>{
  router.push('/Register')
};
</script>

<style>
.loginbox{
  width: 100%;
  height: 768px;
  background-image: url("../assets/images/bgimg.jpg");
  background-size: 100% 100%;
}

.headertext{
  text-align: center;
}

.LoginForm {
  position: absolute;
  right: 10%;
  top: calc(50% - 150px);
  width: 400px;
  height: 250px;
  background-color: rgb(186, 252, 252,0.5);
}

.tobtn{
  width: 100%;
  height: 50px;
  text-align: center;
}
.lobtn{
  width:25%;
}
</style>