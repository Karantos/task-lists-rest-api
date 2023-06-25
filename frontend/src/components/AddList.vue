<template>
  <v-sheet width="600" class="mx-auto ma-6">
    <v-form @submit.prevent>
      <v-text-field 
        v-model="list.name" 
        :rules="list.rules" 
        label="List name"
        clearable
        required
      >
      </v-text-field>
      <v-text-field 
        v-model="list.description"  
        label="List description"
        clearable
      >
      </v-text-field>
      <v-btn type="submit" block class="mt-2" color="secondary" @click="addList" :disabled="!list.name">Save list</v-btn>
    </v-form>
  </v-sheet>
</template>

<script>
import ListsAppDataService from '@/services/ListsAppDataService';

export default {
  name: "save-list",
  data() {
    return {
      list: {
        id: null,
        name: '',
        description: '',
        rules: [
          value => {
            if (value) return true
            return 'You must enter a name for your list.'
          },
        ]
      },
      submitted: false   
    };
  },
  methods: {
    addList() {
      let data = {
        listId: this.list.id,
        listName: this.list.name,
        listDescription: this.list.description
      };

      ListsAppDataService.addList(data)
        .then(response => {
          this.list.id = response.data.id;
          console.log(response.data);
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
}
</script>