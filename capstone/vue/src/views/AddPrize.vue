<template>
    <div class="prize">
        <b-button> Add Prize</b-button>
        <add-prize />
    </div>
</template>

<script>
import addPrize from '@/components/AddPrize'

export default ({
    components: {
        addPrize
    }
});
</script>

<style>
.prize {
    
}
</style>