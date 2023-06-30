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
          </q-card-section>
        </q-card-section>

        <q-separator />

        <q-card-section class="row items-center justify-left">
          <q-table title="Utilizatori" :rows="users" :columns="usersColumns" />
        </q-card-section>
        <q-card-section class="row items-center justify-left">
          <q-table title="Comenzi" :rows="users" :columns="usersColumns" />
        </q-card-section>
        <q-card-section class="row items-center justify-left">
          <q-table title="Produse" :rows="users" :columns="usersColumns" />
        </q-card-section>
      </q-card>
    </q-page>
  </q-page-container>
</template>

<script>
import { defineComponent, ref, onMounted } from 'vue';
// import { api } from 'boot/axios';

export default defineComponent({
  name: 'AdministratorPage',
  setup() {
    const users = ref(null);
    const usersColumns = [
      { name: 'id' },
      { name: 'nume' },
      { name: 'prenume' },
      { name: 'username' },
      { name: 'email' },
    ];
    users.value = [
      {
        name: 'Frozen Yogurt',
        calories: 159,
        fat: 6.0,
        carbs: 24,
        protein: 4.0,
        sodium: 87,
        calcium: '14%',
        iron: '1%',
      },
      {
        name: 'Ice cream sandwich',
        calories: 237,
        fat: 9.0,
        carbs: 37,
        protein: 4.3,
        sodium: 129,
        calcium: '8%',
        iron: '1%',
      },
    ];
    onMounted(() => {
      console.log('on mounted');
      // users.value = api.get('/auth/listAllUsers');
    });
    return { users, usersColumns };
  },
});
</script>

<style></style>
