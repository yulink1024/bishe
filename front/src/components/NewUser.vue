<template>
    <div class="tit">
        <h2>请选择三项您感兴趣的内容</h2><br>    
    </div>
    <div class="centerBox">
        <el-checkbox-group v-model="checkList" :min="1" :max="3">
            <el-checkbox v-for="inte in interestList" :key="inte.id" :label="inte.interest" class="el-checkboxcl"></el-checkbox>
        </el-checkbox-group>
    </div>
    <div class="bottomBtn">
        <el-button type="success" class="btnclass" style="margin-right:20px;" @click="setInitInte()">确定</el-button>
        <el-button type="primary" class="btnclass" style="margin-left:20px;" @click="getList()">换一批</el-button>
    </div>
</template>

<script>
import axios from "axios";
import { useStore } from 'vuex';
import { computed } from 'vue';
import { ElMessage } from 'element-plus';
export default{

    data(){
        const stores =useStore();
        const userinfor = computed(() => this.stores.state.user.userinfo);
        return{
            stores,
            userinfor,
            interestList:[],
            checkList:[],
            chushisco:20.00,
        }
    },
    mounted:function(){
        this.getList();
    },
    methods:{
        async getList(){
            await axios.get("http://localhost:8080/getInsterstList").then((res)=>{
            this.interestList=res.data
        }).catch((error)=>{
            console.log(error)
        })
    },
        setInitInte(){
            axios.post("http://localhost:8080/setUserInterest",{
                uid:this.userinfor.id,
                userName:this.userinfor.userName,
                userInterest11:this.checkList[0],
                userInterest21:this.checkList[1],
                userInterest31:this.checkList[2],
            }).then((res)=>{
                if(res.data){
                    this.userinfor.new=!this.userinfor.new;
                    axios.post("http://localhost:8080//updateIsNew",this.userinfor).then((resu)=>{
                        if(resu.data){
                            axios.post('http://localhost:8080/set',{
                                userNumber:this.userinfor.userNumber
                            }).then((resul)=>{
                                this.stores.commit('user/setUserinfo',resul.data)
                                this.stores.commit('user/setIsonline')
                                ElMessage({
                                message:"选择成功",
                                type:"success"
                                })
                            }).catch((error)=>{
                                console.log(error)
                            })

                            axios.post('http://localhost:8080/GetByUid',{
                                uid:this.userinfor.id,
                            }).then((result)=>{
                                this.stores.commit('UserInterest/setuserInterests',result.data);
                            }).catch((error)=>{
                                console.log(error)
                            })
                        }else{
                            ElMessage({
                                message:"选择出错，请重试",
                                type:"error"
                            })
                        }
                    }).catch((error)=>{
                        console.log(error)
                    })
                }else{
                    ElMessage({
                        message:"选择出错，请重试",
                        type:"error"
                    })
                }
            }).catch((error)=>{
                console.log(error)
            })
        }
    }
}
</script>

<style lang="less" scoped>
.tit{
    width: 100%;
    height: 50px;
    padding: 10px;
    text-align: center;
    color: red;
}

.centerBox{
    width: 100%;
    height: 400px;
    position: relative;

    .el-checkboxcl{
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100px;
        height: 100px;
        border-radius: 50px;
        &:hover{
            color: red;
        }
    }

    /deep/.el-checkbox{
        display: flex;
        width: 100px;
        align-items: center;
        .el-checkbox__inner{
            height: 16px;
            width: 16px;
            //修改选中框中的对勾的大小和位置
            &::after {
            height: 12px;
            left: 6px;
            }
            border-radius: 8px;
        }
    }

    .el-checkboxcl:nth-child(1){
        position: absolute;
        left: 320px;
        top: 50px;
        background-color: rgb(160, 250, 5);
    }

    .el-checkboxcl:nth-child(2){
        position: absolute;
        right: 320px;
        top: 50px;
        background-color: rgb(242, 255, 0);
    }
    .el-checkboxcl:nth-child(3){
        position: absolute;
        left: 220px;
        top: 150px;
        background-color: rgb(0, 255, 247);
    }
    .el-checkboxcl:nth-child(4){
        position: absolute;
        right: 220px;
        top: 150px;
        background-color: rgb(0, 42, 255);
    }
    .el-checkboxcl:nth-child(5){
        position: absolute;
        left: 320px;
        top: 250px;
        background-color: rgb(158, 0, 249);
    }
    .el-checkboxcl:nth-child(6){
        position: absolute;
        right: 320px;
        top: 250px;
        background-color: rgb(5, 250, 189);
    }
}

.bottomBtn{
    width: 100%;
    height: 50px;
    text-align: center;
}

.btnclass{
    margin: 10px;
    width: 75px;
}
</style>