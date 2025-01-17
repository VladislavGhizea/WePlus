const API_BASE_URL = 'http://localhost:8080'; // URL base del tuo backend

/**
 * Wrapper per la gestione delle richieste Fetch.
 * @param {string} url - Endpoint specifico (es. "/PersoneGiuridiche").
 * @param {object} options - Configurazione aggiuntiva della richiesta.
 * @returns {Promise<object>} - Risultato della richiesta in formato JSON.
 */
const fetchWrapper = async (url, options = {}) => {
  try {
    const response = await fetch(`${API_BASE_URL}${url}`, {
      options,
      headers: {
        'Content-Type': 'application/json', // Header comune
        (options.headers || {}), // Header aggiuntivi opzionali
      },
      credentials: 'include', // Consente l'invio di cookie o credenziali
    });

    if (!response.ok) {
      const error = await response.json();
      throw new Error(error.message || `Errore ${response.status}`);
    }

    // Se la risposta non ha contenuto (204 No Content), ritorna null
    return response.status !== 204 ? await response.json() : null;
  } catch (error) {
    console.error('Errore nella richiesta Fetch:', error);
    throw error;
  }
};

export default fetchWrapper;
