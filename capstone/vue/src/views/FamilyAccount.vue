<template>
  <div id="family-account">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="main-family">
      <div id="family-library"></div>
      <div id="account-column">
        <div id="account-list-box"><account-list /></div>
        <div id="add-user-box"><add-user /></div>
      </div>
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
      isLoading: true,
    };
  },
  created() {
    setTimeout(() => {
      this.isLoading = false;
    }, 1250);
  },
};
</script>

<style>
#family-account {
}

#main-family {
  display: flex;
  justify-content: space-evenly;
  align-content: flex-start;
}

.book-turner {
  display: flex;
  justify-content: space-evenly;
  align-content: center;
  padding-top: 50px;
  height: auto;
  width: 150px;
}

#account-column {
  display: flex;
  flex-direction: column;
}
#account-list-box {
  display: flex;
  justify-content: left;
  height: 300px;
  min-height: 0;
  overflow: auto;
  width: 350px;
  box-shadow: 10px 10px 5px rgb(89, 194, 230);
  border: 10px solid rgb(128, 212, 240);
}

#family-library {
  display: flex;
  float: left;
  box-shadow: 10px 10px 5px rgb(89, 194, 230);
  border: 10px solid rgb(128, 212, 240);
  width: 500px;
  height: 200px;
  margin-top: 20px;
}

#add-user-box {
  display: flex;
  flex-wrap: wrap;
  box-shadow: 10px 10px 5px rgb(89, 194, 230);
  border: 10px solid rgb(128, 212, 240);
}
</style>