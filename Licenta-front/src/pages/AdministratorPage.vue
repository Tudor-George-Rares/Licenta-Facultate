<template>
  <q-page-container>
    <q-page padding>
      <q-card>
        <q-card-section class="row items-center justify-center">
          <q-avatar
            size="72px"
            class="q-ma-sm"
            style="background-color: #027be3; color: white"
          >
            <q-icon name="school" />
          </q-avatar>
          <q-card-section>
            <q-card-title class="text-h6">Administrator</q-card-title>
            <q-card-title class="text-subtitle2">
              Administrator page
            </q-card-title>
          </q-card-section>
        </q-card-section>

        <q-separator />

        <q-card-section class="row items-center justify-center">
          <q-list bordered separator>
            <q-item
              v-for="link in linksList"
              :key="link.title"
              clickable
              v-ripple
            >
              <q-item-section avatar>
                <q-icon :name="link.icon" />
              </q-item-section>

              <q-item-section>
                <q-item-label>{{ link.title }}</q-item-label>
                <q-item-label caption lines="2">
                  {{ link.caption }}
                </q-item-label>
              </q-item-section>

              <q-item-section side>
                <essential-link :to="link.link" />
              </q-item-section>
            </q-item>
          </q-list>
        </q-card-section>
      </q-card>
    </q-page>
  </q-page-container>
</template>

<script>
import { defineComponent } from 'vue';

export default defineComponent({
  name: 'AdministratorPage',
  setup() {
    return {};
  },

  data() {
    return {
      linksList: [
        {
          title: 'Produse',
          caption: 'Cele mai calitative produse',
          link: '/products',
          icon: 'school',
        },
        {
          title: 'Categorii',
          caption: 'Cele mai calitative categorii',
          link: '/categories',
          icon: 'school',
        },
        {
          title: 'Utilizatori',
          caption: 'Cele mai calitative utilizatori',
          link: '/users',
          icon: 'school',
        },
        {
          title: 'Comenzi',
          caption: 'Cele mai calitative comenzi',
          link: '/orders',
          icon: 'school',
        },
      ],
    };
  },
});
</script>

<style></style>
