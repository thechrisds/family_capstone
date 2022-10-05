<template>
    <div class="test-search">
        <book-search/>
    </div>
</template>

<script>
import bookSearch from '@/components/BookSearch.vue'
export default{
    components:{
        bookSearch
    },
    name: "test-search",
    data(){
        return{

        }
    }
}
</script>


<style scoped>
.test-search{
    margin-top:200px;
}

</style>
