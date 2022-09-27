<template>
    <div>
        <form class="new-book-form" v-on:submit.prevent="saveBook">
        <input class="title-input" type="text" placeholder="Title" v-model="book.bookTitle" />
        <input class="author-input" type="text" placeholder="Author" v-model="book.bookAuthor" />
        <input class="isbn-input" type="text" placeholder="ISBN" v-model.number="book.isbn" />
        <button class="submitBook" v-on:click="addBooks()">Save</button>
  </form>
        </div>
</template>

<script>
import bookService from '@/services/BookService.js';
export default{
    name: 'add-book',
    data(){
        return {
            book: {
                bookTitle: "",
                bookAuthor: "",
                isbn: "",
                genre: "z",
                description: "No description given"
            }
        }
    },
    methods: {
        addBooks(){
            bookService.addBooks(this.book).then(response =>{
                if(response.status === 200){
                    alert("Success!");
                }
            })
            this.book = {
                bookTitle: "",
                bookAuthor: "",
                isbn: "",
                genre: "z",
                description: "No description given"
            }
            
        },
        checkIfAdded(){
            const allBooks = bookService.seeAll();
            allBooks.forEach((obj) =>{
                if (obj.isbn == this.book.isbn){
                    alert("Book successfully added!")
                }
            })
        }
    }
}
</script>

<style scoped>

</style>