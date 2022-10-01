<template>
  <div id="family-account">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="main-family">
      <div id="family-library">
        <div class="family-library-title">
        Family Library
        </div>
        <div class="family-library-books">

        </div>
      </div>
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

#main-family {
  display: flex;
  justify-content: space-evenly;
 
}

.book-turner {
  display: flex;
  justify-content: space-evenly;
  align-content: center;
  height: auto;
  width: 250px;
  margin: auto;
  margin-top:100px;
 
  
  margin-bottom: 25px;
}

#account-column {
  display: flex;
  flex-direction: column;
}
#account-list-box {
  display: flex;
  justify-content: center;
  height: 300px;
  min-height: 0;
  width: 350px;
  box-shadow: 10px 10px 25px rgb(153, 46, 46);
  border: 1px solid rgb(116, 38, 38);
  height: 100%;
  border-radius: 10px;
  padding-bottom: 25px;
  background-color:white;
}

#add-user-box {
  display: flex;
  flex-wrap: wrap;
  box-shadow: 10px 10px 25px rgb(36, 114, 40);
  border: 1px solid rgb(12, 107, 9);
  border-radius: 10px;
  background-color:white;
}

#family-library {
  display: flex;
  flex-direction: column;
  box-shadow: 10px 10px 25px rgb(44, 55, 201);
  border: 1px solid rgb(15, 29, 90);
  width: 600px;
  height: 350px;
  margin-top: 20px;
  border-radius: 10px;
  font-size: 18px;
  background-color:white;
}

.family-library-title {
  background-color: rgb(166, 166, 228);
  width: 90%;
  align-self: center;
}

.family-library-books {
  align-self: center;
  width: 95%;
  height: 340px;
  overflow-x:scroll;
  border: 2px solid grey;

}


</style>