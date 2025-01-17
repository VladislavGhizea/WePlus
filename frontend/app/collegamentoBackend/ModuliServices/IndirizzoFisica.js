import fetchWrapper from './fetchWrapper';

// Recupera tutti gli indirizzi fisici
export const getAllIndirizziFisica = async () => {
  return await fetchWrapper('/IndirizziFisica');
};

// Recupera un indirizzo fisico per ID
export const getIndirizzoFisicoById = async (id) => {
  return await fetchWrapper(`/IndirizziFisica/${id}`);
};

// Crea un nuovo indirizzo fisico
export const createIndirizzoFisico = async (indirizzoFisico) => {
  return await fetchWrapper('/IndirizziFisica', {
    method: 'POST',
    body: JSON.stringify(indirizzoFisico),
  });
};

// Aggiorna un indirizzo fisico esistente
export const updateIndirizzoFisico = async (id, indirizzoFisico) => {
  return await fetchWrapper(`/IndirizziFisica/${id}`, {
    method: 'PUT',
    body: JSON.stringify(indirizzoFisico),
  });
};

// Elimina un indirizzo fisico
export const deleteIndirizzoFisico = async (id) => {
  return await fetchWrapper(`/IndirizziFisica/${id}`, {
    method: 'DELETE',
  });
};
