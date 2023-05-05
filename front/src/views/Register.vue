<template>
  <div class="registerbox">
    <el-card class="RegisterForm">
      <template #header> <h3 class="headertext">用户注册</h3> </template>
      <div>
        <Form ref="RegisterForm" :model="RegisterForm" :rules="ruleCustom" :label-width="90">
        <FormItem label="手机号码" prop="RegisterName">
            <Input type="text" v-model="RegisterForm.RegisterName"></Input>
        </FormItem>
        <FormItem label="用户名" prop="userName">
            <Input type="text" v-model="RegisterForm.userName"></Input>
        </FormItem>
        <FormItem label="密码" prop="password">
            <Input type="password" v-model="RegisterForm.password" password></Input>
        </FormItem>
        <FormItem label="请重复密码" prop="repassword">
            <Input type="password" v-model="RegisterForm.repassword" password></Input>
        </FormItem>
          <div class="tobtn">
            <el-button type="success" class="lobtn" @click="GetRegister()">注册</el-button>
          </div>
        </Form>
      </div>
    </el-card>
  </div>
</template>

<script>
import { reactive} from "vue";
import axios from "axios";
import {ElMessage} from "element-plus";
import { useRouter } from "vue-router";
import { Input} from "view-ui-plus";

export default {
    data() {
      const router=useRouter();
        const RegisterForm=reactive({
                RegisterName: "",
                userName: "",
                password: "",
                repassword: ""
              });
        const isNumber=(value)=>{         //验证是否为数字
            var patrn = /^(-)?\d+(\.\d+)?$/;
            if (patrn.exec(value) == null || value == "") {
              return false
            } else {
              return true
            }};

        const validatePass = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入密码"));
            }
            else {
                if (this.RegisterForm.repassword != "") {
                    // 对第二个密码框单独验证
                    this.$refs.RegisterForm.validateField("repassword");
                }
                callback();
            }
        };

        const validatePassCheck = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请再次输入密码"));
            }
            else if (value!=this.RegisterForm.password) {
                callback(new Error("两次密码不相同"));
            }
            else {
                callback();
            }
        };

        const validateReName = (rule, value, callback) => {
            if (value === "") {
                callback(new Error("请输入电话号码"));
            }
            else if(!isNumber(value)){
                callback(new Error("请不要包含数字以外字符"));
            }
            else
            {
              callback();
            }
        };

        const validateUseNa=(rule,value,callback)=>{
          if(value===""){
            callback(new Error("请输入用户名"));
          }
          else{
            callback();
          }
        }
        return {
            router,
            RegisterForm,
            isNumber,
            ruleCustom: {
                RegisterName: [
                    { validator: validateReName, trigger: "blur" },
                    {min:11,max:11,message:"请输入正确电话号码"}
                ],
                userName:[
                   { validator: validateUseNa,trigger:"blur"}
                ],
                password: [
                    { validator: validatePass, trigger: "blur" },
                    { min: 6, message: "请输入至少六位秘密" }
                ],
                repassword: [
                    { validator: validatePassCheck, trigger: "blur" }
                ],
            },
        };
    },
    methods: {
       //注册
       GetRegister (){
            if (this.RegisterForm.RegisterName!=""&&this.isNumber(this.RegisterForm.RegisterName)&&this.RegisterForm.RegisterName.length===11) {
              if(this.RegisterForm.userName!=""){
                if(this.RegisterForm.password.length>=6){
                  if(this.RegisterForm.password===this.RegisterForm.repassword){
                    axios({
                      method:'post',
                      url:'http://localhost:8080/Register',
                      data:{
                          userName:this.RegisterForm.userName,
                          userNumber:this.RegisterForm.RegisterName,
                          userPassword:this.RegisterForm.password
                        }
                    }
                    ).then((response)=>{
                      if(response.data){
                        ElMessage({
                        message: "注册成功",
                        type: "success"
                        });
                        this.router.push('/login')
                      }else{
                        ElMessage({
                        message: "注册失败",
                        type: "error"
                        });
                      }
                    }).catch(function(error){
                      console.log(error);
                    }) 
                  }else{
                    ElMessage({
                      message:"两次密码不相同",
                      type:"error"
                    });
                  }
                }else{
                  ElMessage({
                    message:"请输入至少六位密码",
                    type:"error"                  
                  })
                }
              }else{
                ElMessage({
                    message:"请输入用户名",
                    type:"error"                  
                  })
              }
            }else{
              ElMessage({
                    message:"请输入正确的电话号码",
                    type:"error"                  
                  })
            }
        }
    },
    components: { Input }
}
</script>

<style scoped>
.registerbox{
  width: 100%;
  height: 768px;
  background-image: url("../assets/images/Register.jpg");
  background-size: 100% 100%;
}

.headertext{
  text-align: center;
}
.RegisterForm {
  position: absolute;
  right: 10%;
  top: calc(50% - 150px);
  width: 400px;
  height: 400px;
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