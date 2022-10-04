<template>
    <div class="info-container">
        <div class="modal-book-info">
        <b-form-input v-model="bookTitle"/>
        {{book.bookTitle}}
        {{book.bookType}}
        {{book.description}}
        {{book.familyId}}
        {{book.genre}}
        {{book.isbn}}
        </div>
    </div>
</template>

<script>
export default{
    props: ['book'],
    data(){
        return {
            
            
        };
    }
}
</script>

<style>


</style>
