<template>
  <div id="family-account">
    <div class="loading" v-if="isLoading">
      <img class ="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else >
    <div id="account-list"><account-list /></div>
    <div id="family-library"></div>
    <div id="add-user"><add-user /></div>
    </div>
    
  </div>
</template>

<script>
import AccountList from "@/components/AccountList";
import AddUser from "@/components/AddUser";

export default {
  components: {
    AccountList,
    AddUser,
  },
  data() {
    return {
      isLoading: true
    }
  },
  created() {
    setTimeout(() => {
            this.isLoading = false;
          }, 1250);
  }
};
</script>

<style>
#family-account{
  min-height:0;
}

.book-turner {
  display:flex;
  justify-content: space-evenly;
  align-content: center;
  padding-top: 50px;
  height: auto;
  width: 150px;
}

#account-list{
  display: flex;
  flex-wrap: wrap;
  height: 250px;
  min-height:0;
  overflow:auto;
  width:350px;
  float: right;
}

#family-list{
  border: 2px solid;
}
</style>