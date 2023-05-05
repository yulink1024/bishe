<template>
  <div class="top-bar">
    <div class="w">
        <ul>
            <li><a href="javascript:;">首页</a></li>
            <template v-if=userinfor.isonline>
                <li>
                    <a @click="openuser()">{{userinfor.userName}}</a>
                        <div id="userinfocard" class="userinfocard">
                            <Card class="userme">
                                <!-- 信息页面 -->
                                <Form v-show="!is_update">
                                    <Row>
                                        <Col span="12">
                                        <FormItem  label="id:" style="margin-bottom:18px">{{userinfor.id}}</FormItem>
                                        </Col>
                                        <Col span="12">
                                        <FormItem  label="用户名:" style="margin-bottom:18px">{{userinfor.userName}}</FormItem>
                                        </Col>
                                    </Row> 
                                    <Row>
                                        <Col span="12">
                                        <FormItem  label="性别:" style="margin-bottom:18px">{{ userinfor.gender }}</FormItem>
                                        </Col>
                                        <Col span="12">
                                        <FormItem  label="年龄:" style="margin-bottom:18px">{{ userinfor.age }}</FormItem>
                                        </Col>
                                    </Row>
                                    <Row>
                                        <Col span="12">
                                        <FormItem  label="电话号码:" style="margin-bottom:18px">{{ userinfor.userNumber }}</FormItem>
                                        </Col>
                                        <Col span="12">
                                        <FormItem  label="地址:" style="margin-bottom:18px">{{ userinfor.userAddress }}</FormItem>
                                        </Col>
                                    </Row>                              
                                </Form>
                                <div class="userbtn" v-show="!is_update">
                                    <el-button type="primary" style="width:25%" @click="updateuser()">修改</el-button>
                                    <el-button type="success" style="width:25%" @click="closeuser()">关闭</el-button>
                                </div>
                                <!-- 修改信息页面 -->
                                <Form :label-width="80" v-show="is_update">
                                <Row>
                                    <Col span="12">
                                        <FormItem  label="id:" style="margin-bottom:18px">
                                            {{ userinfor.id }}
                                        </FormItem>
                                    </Col>
                                    <Col span="12">
                                        <FormItem  label="用户名:" style="margin-bottom:18px">
                                            <Input type="text" v-model=userinfor.userName></Input>
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span="12">
                                        <FormItem  label="性别:" style="margin-bottom:18px">
                                            <RadioGroup v-model="userinfor.gender">
                                                <Radio label="保密"></Radio>
                                                <Radio label="男"></Radio>
                                                <Radio label="女"></Radio>
                                            </RadioGroup>
                                        </FormItem>
                                    </Col>
                                    <Col span="12">
                                        <FormItem  label="年龄:" style="margin-bottom:18px">
                                            <Input v-model.number=userinfor.age></Input>
                                        </FormItem>
                                    </Col>
                                </Row>
                                <Row>
                                    <Col span="12">
                                        <FormItem  label="电话号码:" style="margin-bottom:18px">
                                            <Input type="text" v-model=userinfor.userNumber></Input>
                                        </FormItem>
                                    </Col>
                                    <Col span="12">
                                        <FormItem  label="地址:" style="margin-bottom:18px">
                                            <Input type="text" v-model=userinfor.userAddress></Input>
                                        </FormItem>
                                    </Col>
                                </Row>
                                </Form>
                                <div class="userbtn" v-show="is_update">
                                    <el-button type="primary" style="width:25%" @click="saveuser()">保存</el-button>
                                    <el-button type="success" style="width:25%" @click="closeupdate()">取消</el-button>
                                </div>
                            </Card>
                        </div>
                </li>
                <li><a @click="userquit">退出登录</a></li>
            </template>
            <li v-else><a href="/#/login">登陆/注册</a></li>
            <li><a href="/#/Dingdan">我的订单</a></li>
            <li><a href="javascript:;">会员</a></li>
            <li><a href="javascript:;"><i class="iconfont icon-kefu"></i>客户服务</a></li>
        </ul>
    </div>
  </div>
</template>

<script>
import { useStore } from 'vuex';
import { useRouter } from 'vue-router';
import { computed } from 'vue';
import { ElMessage } from 'element-plus';
import { FormItem } from 'view-ui-plus';
import axios from 'axios';
export default {
    data() {
        const isNumber=(value)=>{         //验证是否为数字
            var patrn = /^(-)?\d+(\.\d+)?$/;
            if (patrn.exec(value) == null || value == "") {
              return false
            } else {
              return true
            }};
        const router = useRouter();
        const stores = useStore();
        const userinfor = computed(() => stores.state.user.userinfo);
        return {
            userinfor,
            stores,
            is_update:false,
            isNumber,
            userquit: () => {
                stores.commit("user/setIsonline");
                ElMessage({
                    message: "已退出登陆",
                    type: "success"
                });
                router.push("/");
            },
        };
    },
    methods: {
        openuser:()=>{
            document.getElementById("userinfocard").style.display="block"
        },
        closeuser:()=>{
            document.getElementById("userinfocard").style.display="none"
        },
        updateuser(){
            this.is_update=true;
        },
        closeupdate(){
            this.is_update=false;
        },
        saveuser(){
            if(this.isNumber(this.userinfor.age)){
            axios.post('http://localhost:8080/updateus',
                this.userinfor
            ).then((res)=>{
                if(res.data==='success'){
                    this.is_update=false;
                    axios.post('http://localhost:8080/set',{
                        userNumber:this.userinfor.userNumber
                        }).then((res)=>{
                            this.stores.commit('user/setUserinfo',res.data)
                            this.stores.commit('user/setIsonline')
                        }).catch((error)=>{
                            console.log(error);
                        })
                    ElMessage({
                    message: "信息修改成功",
                    type: "success"
                    });
                }else if(res.data==='error'){
                    ElMessage({
                    message: "信息修改失败",
                    type: "error"
                    });
                }else if(res.data==='ageError'){
                    ElMessage({
                        message:"请检查年龄是否填写正确",
                        type:"error"
                    });
                }
            }).catch((error)=>{
                console.log(error)
            })
        }else{
            ElMessage({
                message:"年龄请输入数字",
                type:"error"
            })
        }
    }
    },
    components: { FormItem }
}
</script>

<style lang="less" scoped>
.top-bar{
    background-color: #333;
    ul{
        display: flex;
        justify-content: flex-end;
        height: 53px;
        line-height: 53px;
    }
    li{
        a{
            color: #ccc;
            padding: 0px 10px;
            border-left:1px solid #ccc;
            &:hover{
                color: @xtxColor;
            }
        }
    }
    li:nth-child(1){
        a{
            border-left: 0px;
        }
    }
}


.userinfocard{
    display: none;
    position: absolute;
    z-index: 1;
    left: 54%;
    top: 50px;
    margin: 3px;
    padding: 0px;
    width: 470px;
    height: 110px;
}

.userme{
    background-color: rgba(111, 228, 251, 0.7); 
    /deep/.ivu-card-body{
        padding: 10px 0 0 10px;
    }
}

.userbtn{
    width: 100%;
    text-align: center;
}


</style>