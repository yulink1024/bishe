<template>
    <div class="layer">
        <ul>
            <li>
                <a href="#">
                <img src="@/assets/images/197535cfcb8a24a7.png.webp" alt />
                </a>
                <div>
                    艺术
                </div>
            </li>
            <li>
                <a href="#">
                <img src="@/assets/images/197535cfcb8a24a7.png.webp" alt />
                </a>
                <div>
                    艺术
                </div>
            </li>
        </ul>
    </div>
</template>

<script>
export default {

}
</script>

<style lang="less" scoped>
.layer{
        position: absolute;
        left: 250px;
        top: 170px;
        padding: 10px;
        background-color: white;
        border: 1px solid #ccc;
        box-shadow: 0 0 5px #ccc;
        width: 1000px;
        height: 130px;
        ul{
            li{
                height: 100px;
                width: 50px;
                line-height: 40px;
                float: left;
                margin: 10px;
                img{
                    width:50px;
                    height: 50px;
                    text-align: center;
                }
                div{
                    text-align: center;
                }
            }
            li:hover{
                        color: @xtxColor;
                        border-bottom: 2px solid @xtxColor;
                    }
        }
    }
</style>