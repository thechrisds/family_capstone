<template>
  <div class="prize-table-container">
    <div class="pt-table-main">
      <div class="pt-table">
        <b-table
          selectable
          striped
          hover
          :select-mode="'single'"
          :items="prizes"
          :fields="fields"
          @row-clicked="clickDeleteID"
          class="prizes-table"
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
    </div>
  </div>
</template>



<script>
import prizeService from "@/services/PrizeService.js";
export default {
  name: "prize-table",
  data() {
    return {
      date: "",
      prize: [],
      active: "",
      prizes: [],
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
      console.log(response.data)
    },
    
    
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

.active-activity{
  display:flex;
  justify-content: center;
}

.prize-table-container {
  margin-left: auto;
  margin-right: auto;
  width:90%;
  
}

.prizes-table {
  font-size: 1vw;
  background-color: #a8d0e6;
  border-radius: 10px;
  width:500px;
}

.pt-table::-webkit-scrollbar {
  width: 5px; /* width of the entire scrollbar */
}

.pt-table::-webkit-scrollbar-thumb {
  background-color: rgb(216, 181, 181); /* color of the scroll thumb */
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
}

.pt-table{
 max-height: 250px;
 overflow-y: scroll;
}



</style>