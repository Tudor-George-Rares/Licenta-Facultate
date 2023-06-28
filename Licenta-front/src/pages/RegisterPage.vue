<template>
  <q-page class="flex flex-center">
    <q-card class="q-ma-xl" style="max-width: 800px">
      <q-card-section>
        <q-form @submit="onSubmit">
          <q-input
            v-model="nume"
            label="Nume"
            lazy-rules
            :rules="[(val) => !!val || 'Password is required']"
          />
          <q-input
            v-model="prenume"
            label="Prenume"
            lazy-rules
            :rules="[(val) => !!val || 'Password Confirmation is required']"
          />
          <q-input
            v-model="email"
            label="Email"
            lazy-rules
            :rules="[(val) => !!val || 'Email is required']"
          />
          <q-input
            v-model="username"
            label="Username"
            lazy-rules
            :rules="[(val) => !!val || 'Username is required']"
          />
          <q-input
            v-model="password"
            label="Password"
            lazy-rules
            :rules="[(val) => !!val || 'Password is required']"
          />
          <q-input
            v-model="adresa"
            label="Address"
            lazy-rules
            :rules="[(val) => !!val || 'Address is required']"
          />
          <q-input
            v-model="telefon"
            label="Telefon"
            lazy-rules
            :rules="[(val) => !!val || 'Telefon is required']"
          />

          <q-btn
            type="submit"
            label="Register"
            color="primary"
            class="q-mt-md"
          />
        </q-form>
      </q-card-section>
    </q-card>
  </q-page>
</template>

<script>
import { defineComponent, ref } from 'vue';
import { api } from 'boot/axios';
import { useRouter } from 'vue-router';
export default defineComponent({
  setup() {
    const email = ref('');
    const password = ref('');
    const nume = ref('');
    const prenume = ref('');
    const telefon = ref('');
    const adresa = ref('');
    const username = ref('');
    const router = useRouter();
    const onSubmit = async () => {
      try {
        const response = await api.post('/auth/signup', {
          username: username.value,
          password: password.value,
          email: email.value,
          nume: nume.value,
          prenume: prenume.value,
          telefon: telefon.value,
          adresaCompleta: adresa.value,
          role: ['user'],
        });
        if (response.status === 200) {
          router.push('/');
        }
      } catch (error) {
        console.error(error);
      }
    };

    return {
      email,
      password,
      onSubmit,
      nume,
      prenume,
      telefon,
      adresa,
      username,
    };
  },
});
</script>

<style></style>
