<template>
  <div id="family-account">
    <div class="loading" v-if="isLoading">
      <img class="book-turner" src="../assets/bookturner-small.gif" />
    </div>
    <div v-else id="main-family">
      <!-- <div class="row-1">
        <div id="family-library">
          <div class="family-library-title">Library.</div>
          <div class="family-library-books-container">
            <div class=family-library-books>
          <personal-book />
          </div>
          </div>
        </div>
        
      </div> -->
      <div id="row-2">
        <div id="account-list-box">
          <account-list class="account-list-component" />
        </div>
        <div id="add-user-box"><add-user /></div>
      </div>
      <div class="row-3">
        <div class="fa-prize-container">
          <div class="prizes-title">Prizes.</div>
          <div class="fa-prize-table">
            
            <prize-table />
            
          </div>
          <div class="prizes-link-div">
              <router-link class="prizes-link" v-bind:to="{ name: 'prizes' }"
                >See all prizes.</router-link
              >
            </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import AccountList from "@/components/AccountList";
import AddUser from "@/components/AddUser";
import bookService from "@/services/BookService.js";
import PrizeTable from "@/components/PrizeTable";
//import PersonalBook from "@/components/PersonalBook"

export default {
  components: {
    AccountList,
    AddUser,
    PrizeTable,
    // PersonalBook
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

    bookService.seeOpenBooks().then((response) => {
      this.books = response.data;
    }).catch;
  },
};
</script>

<style>
#main-family {
  display: flex;
  flex-direction: column;
  background-color: #f4f7f6;

}

.book-turner {
  display: flex;
  justify-content: space-evenly;
  align-content: center;
  height: auto;
  width: 250px;
  margin: auto;
  margin-top: 100px;
  margin-bottom: 25px;
}

#row-2 {
  display: flex;
  flex-direction: row;
  margin-top: 80px;
  margin-left: auto;
  margin-right: auto;
  justify-content: space-between;
  width: 90%;
}

#add-user-box {
  height: 300px;
}

.row-3 {
  width: 90%;
  height: auto;
  margin-top: 20px;
  border-radius: 10px;
  font-size: 18px;
  background-color: #374785;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 40px;
  padding-bottom:30px;
}

.fa-prize-container {
  display: flex;
  flex-direction: column;
  align-self: center;
  width: 90%;
  height: 400px;
  justify-content: center;
  padding-top:10px;
  
}

.fa-prize-table{
  margin-left:auto;
  margin-right:-100px;
}

.prizes-title {
  color: #f8e9a1;
  font-weight: 600;
  margin-left: 40px;
 margin-top:35px;
  margin-bottom:10px;
}
.prizes-link-div{
  padding-top:10px;
  margin-top:0px;
  margin-bottom:20px;
  align-self: flex-end;
  margin-right:-35px;
}

.prizes-link {
  color: #f8e9a1;
  text-decoration: underline solid transparent;
  transition: text-decoration 1s ease;
  font-weight: 600;
  margin-left: 40px;
}

.prizes-link:hover {
    text-decoration: underline solid #f8e9a1;
}

.family-members-table>.table>tbody>tr:first-child{
  background-color:gold;
  font-weight: 600;
}

.family-members-table>.table>tbody>tr:nth-child(2){
  background-color:silver;
}

.family-members-table>.table>tbody>tr:nth-child(3){
  background-color:#a03921;
}



</style>