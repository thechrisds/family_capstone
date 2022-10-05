<template>
    <div class="prizes-main-container">
        <prize-table />
        <div id="delete">
        <b-button v-on:click="confirmDelete">Delete Selected Prize</b-button>
        <b-button  @click="setPrize">Edit Selected Prize</b-button>
        <b-button @click="addPrize"> Add Prize </b-button>
        </div>
    </div>
</template>

<div class="test">
        <b-button> Add Prize </b-button>
        </div>

        <!-- <b-modal id="modal-1" hide-footer title="Prize Info">
             <div class="edit-prize-div">
          <edit-prize />
             </div>
        </b-modal>   -->

<script>
import prizeTable from '@/components/PrizeTable'
import prizeService from '@/services/PrizeService.js';

export default {
    props: ["edit-prize"],
    components: {
        prizeTable,
        
    },
    data(){
        return {
            prize: [],
            boxOne: '',
            boxTwo:'',
            editedPrize: {
                prize_id: 0,
                name: "",
                description: "",
                goal: 0,
                stock: 0,
                start_date: "",
                end_date: ""
            }
        }

    },
    methods: {
        deletePrize(){
          prizeService.deletePrize(this.$store.state.prize.prize_id);
        },
        confirmDelete(){
            this.boxOne = ''
            this.$bvModal.msgBoxConfirm('Are you sure you want to delete this prize?').then(value => {
                if (value === true){
                    prizeService.deletePrize(this.$store.state.prize.prize_id);
                    this.$router.go({name: 'prizes'})
                }
            })
            
        },
        sendToEdit(){
            this.boxTwo = ''
            // this.$bvModal.msgBoxConfirm('Are you sure you want to delete this prize?').then(value => {
            //     if (value === true){
            //         prizeService.deletePrize(this.$store.state.prize.prize_id);
            //         this.$router.go({name: 'prizes'})
            //         return 'editPrize';
            //     
            // 
            prizeService.editPrize(this.$store.state.prize.prize_id);
        },
        showEditModal(){
            this.boxTwo = '';
        },
        setPrize(){
            this.$router.push({name: 'edit-prize', params: { id: this.$store.state.prize.prize_id }})
        },
        addPrize(){
            this.$router.push({name: "add-prize"})
        }

    },
    created(){
        
    }
};
</script>

<style scoped>

.modal-buttons{
display:flex;
justify-content: space-between;
}

.edit-container{
    width: 100%;
    margin-top: -2px;
}

.test{
    margin-top:200px;
}

#delete{
    display:flex;
    justify-content: space-evenly;
    align-content:flex-end;
    max-width: 100%;
    margin-left: 100px;
}
</style>