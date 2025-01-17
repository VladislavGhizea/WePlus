import fetchWrapper from './fetchWrapper';

// Recupera tutte le sedi
export const getAllSedi = async () => {
  return await fetchWrapper('/Sedi');
};

// Recupera una sede per ID
export const getSedeById = async (id) => {
  return await fetchWrapper(`/Sedi/${id}`);
};

// Crea una nuova sede
export const createSede = async (sede) => {
  return await fetchWrapper('/Sedi', {
    method: 'POST',
    body: JSON.stringify(sede),
  });
};

// Aggiorna una sede esistente
export const updateSede = async (id, sede) => {
  return await fetchWrapper(`/Sedi/${id}`, {
    method: 'PUT',
    body: JSON.stringify(sede),
  });
};

// Elimina una sede
export const deleteSede = async (id) => {
  return await fetchWrapper(`/Sedi/${id}`, {
    method: 'DELETE',
  });
};
