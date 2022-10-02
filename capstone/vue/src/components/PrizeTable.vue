<template>
    <div class="prize-table">
        <b-table striped hover :items="prizes"></b-table>
    </div>
</template>



<script>
import prizeService from '@/services/PrizeService.js';
export default {
    name: 'prize-table',
    data(){
        return {
            prizes: []

        }

    },
    created() {
        prizeService.getPrizes().then(response=>{
                this.prizes = response.data;
        })
    }
}
</script>


<style>
.prize-table{
    margin-top: 200px;
    margin-left: 100px;
    margin-right: 100px;
}
</style>