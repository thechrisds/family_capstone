<template>
  <div class="prize-table-container">
    <div class="active-inactive-all">
    <b-form-radio v-model="show" value="all">Show All</b-form-radio>
    <b-form-radio v-model="show" value="active">Show Active</b-form-radio>
    <b-form-radio v-model="show" value="inactive">Show Inactive</b-form-radio>
    </div>
    <!-- dark blue background below -->
    <div class="pt-table-main">
    <!-- actual table below-->
  
      <!-- SHOW ALL PRIZES -->
      <div class="pt-table" v-if="show=='all'">
        <b-table
          selectable
          
          striped
          hover
          :select-mode="'single'"
          :items="prizes"
          :fields="fields"
          @row-clicked="clickDeleteID"
          class="prizes-table"
          label-sort-clear=""
          
        >
        <template #cell(status)="data">
        <div class="active-activity">
          <div class="danger" v-if="!checkActive(data.item.end_date)">
           <b-icon icon="circle-fill" scale="2" variant="danger"/>
          </div>
          <div class="active-p" v-else>
            <b-icon icon="circle-fill" scale="2" variant="success"/>
          </div>
          
        </div>
      </template>
        </b-table>
      </div>

      <!-- SHOW ACTIVE PRIZES -->
      <div class="pt-table" v-if="show=='active'">
        <b-table
          selectable
          fixed
          striped
          hover
          :select-mode="'single'"
          :items="activePrizes"
          :fields="fields"
          @row-clicked="clickDeleteID"
          class="prizes-table"
          label-sort-clear=""
          
        >
        <template #cell(status)="data">
        <div class="active-activity">
          <div class="danger" v-if="checkActive(data.item.end_date)">
           <b-icon icon="circle-fill" scale="2" variant="success"/>
          </div>
        </div>
      </template>
        </b-table>
      </div>

      <!-- SHOW INACTIVE PRIZES -->
      <div class="pt-table" v-if="show=='inactive'">
        <b-table
          selectable
          striped
          fixed
          hover
          :select-mode="'single'"
          :items="inactivePrizes"
          :fields="fields"
          @row-clicked="clickDeleteID"
          class="prizes-table"
          label-sort-clear=""
          
        >
        <template #cell(status)="data">
        <div class="active-activity">
          <div class="danger" v-if="!checkActive(data.item.end_date)">
           <b-icon icon="circle-fill" scale="2" variant="danger"/>
          </div>
          
        </div>
      </template>
        </b-table>
      </div>
    </div>
  </div>
</template>



<script>
import prizeService from "@/services/PrizeService.js";
export default {
  name: "prize-table",
  data() {
    return {
      show: "",
      date: "",
      prize: [],
      active: "",
      prizes: [],
      activePrizes: [],
      inactivePrizes: [],
      fields: [
        {
          key: "prize_id",
          label: "Prize #",
        },
        {
          key: "name",
          sortable: true,
        },
        {
          key: "description",
          sortable: false,
        },
        {
          key: "goal",
          sortable: true,
        },
        {
          key: "stock",
          sortable: true,
          label: "Prizes Remaining",
        },
        {
          key: "start_date",
          sortable: true,
        },
        {
          key: "end_date",
          sortable: true,
        },
        {
          Status: 1
        }
        
      ],
    };
  },
  created() {
    prizeService.getPrizes().then((response) => {
      this.prizes = response.data;
      console.log(response.data);
      this.activePrizes = this.prizes.filter( (prize) =>{
        return (Date.now() < new Date(prize.end_date))
      })
      this.inactivePrizes = this.prizes.filter( (prize) =>{
        console.log(prize.end_date)
        console.log(new Date(prize.end_date))
        return (Date.now() > new Date(prize.end_date))
      })
      console.log(this.inactivePrizes)
      console.log(this.activePrizes)
    },
    this.show = "all",
    
    
    );
  },
  methods: {
    clickDeleteID(item) {
      // "family_id": 0,
      //     "name": "",
      //     "description": "",
      //     "goal": 0,
      //     "stock": 0,
      //     "start_date": "",
      //     "end_date": ""
      this.$store.commit("SET_PRIZE", item);
    },
    checkActive(date){
      this.date = new Date().getDate;
      return (Date.now() < new Date(date))
    },
    checkInactive(date){
      return (new Date().getDate() >= date)
    }
  },
  
};
</script>


<style>
.active-inactive-all{
  display:flex;
  padding: 10px;
}

.active-inactive-all>:nth-child(1){
  padding-right: 10px;
}

.active-inactive-all>:nth-child(2){
  padding-right: 10px;
}

.active-activity{
  padding-left: 10px;
}

.prize-table-container {
  margin-left: auto;
  margin-right: auto;
  width:90%;
  resize: both;
  
}

.prizes-table {
  font-size: 1vw;
  background-color: #a8d0e6;
  border-radius: 10px;
}

.pt-table::-webkit-scrollbar {
  width: 8px; /* width of the entire scrollbar */
}

.pt-table::-webkit-scrollbar-thumb {
  background-color: #f8e9a1; /* color of the scroll thumb */
  border-radius: 5px; /* roundness of the scroll thumb */
}
.pt-table::-webkit-scrollbar-track {
  box-shadow: inset 0 0 5px rgb(211, 178, 178);
  border-radius: 5px;
}

.pt-table-main {
  display: flex;
  justify-content: space-between;
  background-color: #24305e;
  color: white;
  border-radius: 10px;
  padding:20px;
  height:100%;
}

.pt-table{
 max-height:300px;
 overflow-y: scroll;
 margin:auto;
}



</style>