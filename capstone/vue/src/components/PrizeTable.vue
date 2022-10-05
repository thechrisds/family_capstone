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
      prize: [],
      prizes: [],
      fields: [
        {
          key: "family_id",
          sortable: false,
        },
        {
          key: "prize_id",
          sortable: true,
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
          label: "# Remaining",
        },
        {
          key: "start_date",
          sortable: true,
        },
        {
          key: "end_date",
          sortable: true,
        },
      ],
    };
  },
  created() {
    prizeService.getPrizes().then((response) => {
      this.prizes = response.data;
    });
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
  },
};
</script>


<style>
.prize-table-container {
  margin-left: auto;
  margin-right: auto;
  width:85%;
  
}

.prizes-table {
  font-size: 1vw;
  background-color: #a8d0e6;
  border-radius: 10px;
  
  width:500px;
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
  overflow-y: scroll;
  scroll-behavior: smooth;
}

.pt-table::-webkit-scrollbar {
  width: 5px;               /* width of the entire scrollbar */
}

.pt-table::-webkit-scrollbar-thumb {
  background-color: rgb(221, 221, 233);    /* color of the scroll thumb */
  border-radius: 3px;       /* roundness of the scroll thumb */
}
.pt-table::-webkit-scrollbar-track {
  box-shadow: inset 0 0 3px rgb(202, 182, 182);
  border-radius: 3px;
}

</style>