<template>
     <div class="booklist-container">
         <div class="background-container">
         <h2>Add a Book</h2>
         <br/>
         <b-form class="new-book-form" @submit.prevent="saveBook">
             <div class="col-sm-5">
         <b-form-input class="title-input" type="text" placeholder="Title" v-model="book.bookTitle" />
         <br />

         <b-form-input class="author-input" type="text" placeholder="Author" v-model="book.bookAuthor" />
         <br/>

         <b-form-input class="isbn-input" type="text" placeholder="ISBN" v-model.number="book.isbn"/>
         <br/>
            </div>
         <!-- <b-form-input class="genre-input" type="text" placeholder="Genre" v-model.number="book.genre"/>
         <br/>
         <br/> -->
        <b-form-select v-model="genre" :options="options"></b-form-select>
        <br/>
        <br/>
         <b-textarea rows="5" max-rows="10" class="description-input" type="text" placeholder="Description..." v-model="book.description"/>
         <br/>
         <div class="addbook-buttons">
         <b-button v-on:click="$router.go(-1)"> Go Back </b-button>
         <b-button type="submit" v-on:click="addBooks()">Save</b-button>
         </div>
   </b-form>
         </div>
         </div>
</template>

<div>
        <form class="isbn-search" v-on:click.prevent="bookSearch()">
            <input class="isbn-input" type="text" placeholder="ISBN" v-model.number="book.isbn" />
            <button class="submitIsbn">Search</button>
            </form>
            {{bookResults.title}}
            
    </div>





<script>
import bookService from '@/services/BookService.js';
export default{
    name: 'add-book',
    data(){
        return {
            bookResults:[], //the search results from the google api query go here
            book: {
                bookTitle: "",
                bookAuthor: "",
                isbn: "",
                genre: "",
                description: ""
            },
            genre: "Genre",
            options: [
                {value: "Genre", text: "Select a Genre", disabled: true},
                {value: 'Fiction', text: 'Fiction'},
                {value: 'Non-Fiction', text: 'Non-Fiction'},
                {value: 'Fantasy', text: 'Fantasy'},
                {value: 'Science Fiction', text: 'Science Fiction'},
                {value: 'Action & Adventure', text: 'Action & Adventure'},
                {value: 'Mystery', text: 'Mystery'},
                {value: 'Horror', text: 'Horror'},
                {value: 'Thriller/Suspense', text: 'Thriller/Suspense'},
                {value: 'Romance', text: 'Romance'},
                {value: 'Graphic Novel', text: 'Graphic Novel'},
                {value: 'Biography', text: 'Biography'},
                {value: 'Art & Photography', text: 'Art & Photography'},
                {value: 'Food & Drink', text: 'Food & Drink'},
                {value: 'History', text: 'History'},
                {value: 'Travel', text: 'Travel'},
                {value: 'Comedy', text: 'Comedy'},
                {value: 'True Crime', text: 'True Crime'},
                {value: 'Science & Technology', text: 'Science & Technology'},
            ]
        }
    },
    methods: {
        addBooks(){
            bookService.addBooks(this.book).then(response =>{
                if(response.status === 200){
                    console.log(response);
                    alert("Success!");
                    this.$router.push({name: 'showBooks'})
                } else if (response.status === 500){
                    alert("Adding book failed!")
                }
            })
            this.book = {
                bookTitle: "",
                bookAuthor: "",
                isbn: "",
                genre: "",
                description: ""
            }
            
        },
        checkIfAdded(){
            const allBooks = bookService.seeAll();
            allBooks.forEach((obj) =>{
                if (obj.isbn == this.book.isbn){
                    alert("Book successfully added!")
                }
            })
        },
        bookSearch(){
            bookService.googleBook(this.book.isbn).then(response =>{
                this.bookResults = response.data.items[0].volumeInfo;
            })
            
        }
    }
}
</script>

<style>

.addbook-buttons{
    display:flex;
    justify-content: space-between;
}

.booklist-container{
    margin: auto;
    width: 50%;
    height: 800px;
    
    margin-top: 150px;
    justify-content:center;
    padding: 15px;
    
}

.background-container{
    height: 550px;
    padding: 10px;
    background-color: #f2f2f2;
}
.new-book-form{
    
}

.title-input{
    
}

.author-input{
    
    
}

.isbn-input{
    

}

.description-input {
    
}

.genre-input {
    
}

h2{
    text-align:center;
    
}
 </style>