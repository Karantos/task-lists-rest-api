<template>
  <v-app id="inspire">
    <v-navigation-drawer v-model="drawer" class="bg-secondary">
      <v-list class="bg-primary">
        <v-list-item prepend-avatar="https://randomuser.me/api/portraits/men/10.jpg" title="Jan Repar"
          subtitle="jan.repar@outlook.com"></v-list-item>
      </v-list>

      <v-divider></v-divider>

      <v-list density="compact" nav>
        <v-list-item prepend-icon="mdi-home-variant" title="Home" value="home" to="/"></v-list-item>
        <v-list-item prepend-icon="mdi-format-list-group-plus" title="New List" value="new-list"
          to="/add-list"></v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-app-bar class="bg-primary">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>Lists App</v-toolbar-title>
      <v-row class="d-flex mr-1 mt-2 justify-end">
        <v-col cols="auto">
          <v-switch prepend-icon="mdi-theme-light-dark" v-model="darkMode" @change="toggleTheme()"></v-switch></v-col>
      </v-row>
    </v-app-bar>

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script setup>
import { ref } from 'vue'
import { useTheme } from "vuetify";

const drawer = ref(null)

const theme = useTheme();
const darkMode = ref(false);

const toggleTheme = () => {
  theme.global.name.value = darkMode.value ? "dark" : "light";
}

</script>

<script>
export default {
  data() {
    return {
      drawer: null 
    }
  }
}
</script>

