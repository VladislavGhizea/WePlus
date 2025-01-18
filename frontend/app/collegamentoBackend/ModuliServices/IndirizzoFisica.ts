import fetchWrapper from '../fetchWrapper';

interface IndirizzoFisico {
  // Definisci qui le proprietà dell'interfaccia IndirizzoFisico
  id?: number;
  via: string;
  citta: string;
  cap: string;
  provincia: string;
  stato: string;
}

// Recupera tutti gli indirizzi fisici
export const getAllIndirizziFisica = async (): Promise<IndirizzoFisico[]> => {
  return await fetchWrapper('/IndirizziFisica') as IndirizzoFisico[];
};

// Recupera un indirizzo fisico per ID
export const getIndirizzoFisicoById = async (id: number): Promise<IndirizzoFisico> => {
  return await fetchWrapper(`/IndirizziFisica/${id}`) as IndirizzoFisico;
};

// Crea un nuovo indirizzo fisico
export const createIndirizzoFisico = async (indirizzoFisico: IndirizzoFisico): Promise<IndirizzoFisico> => {
  return await fetchWrapper('/IndirizziFisica', {
    method: 'POST',
    body: JSON.stringify(indirizzoFisico),
  }) as IndirizzoFisico;
};

// Aggiorna un indirizzo fisico esistente
export const updateIndirizzoFisico = async (id: number, indirizzoFisico: IndirizzoFisico): Promise<IndirizzoFisico> => {
  return await fetchWrapper(`/IndirizziFisica/${id}`, {
    method: 'PUT',
    body: JSON.stringify(indirizzoFisico),
  }) as IndirizzoFisico;
};

// Elimina un indirizzo fisico
export const deleteIndirizzoFisico = async (id: number): Promise<void> => {
  await fetchWrapper(`/IndirizziFisica/${id}`, {
    method: 'DELETE',
  });
};