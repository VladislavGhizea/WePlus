import { SERVER } from '../../variables'

interface User {
    soggetto_id: number;
    username: string;
    email: string;
    password: string;
    tipo: "FISICA" | "GIURIDICA" | "INDIVIDUALE" | "ADMIN";
    cancellato: boolean;
}

const login = async (username: string, password: string): Promise<{ success: boolean, user?: any, error?: string }> => {

    if(!username || !password){   
        return {success: false, error:"Username e password sono richiesti"};
    }
    
    try{
        const response = await fetch(`${SERVER}/utentiGenerali`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username, password }),
        });

        if (!response.ok) {  //.ok ritorno 200 - 299 se è ok
            // Se la risposta non è ok ritorna un errore
            return { success: false, error: "Credenziali non valide" };
        }

        const data = await response.json();

        // Salva i dati necessari nel localStorage (se necessario)
        //localStorage.setItem('token', data.token); //TODO
        /*localStorage.setItem('username', data.user.username);
        localStorage.setItem('password', data.user.password);
        localStorage.setItem('role', data.user.role);*/

        // Ritorna i dati dell'utente
        return { success: true, user: data.user };


    }catch(error){
        console.error(`Abbiamo avuto un problema con il login: ${error}`)
        return { success: false, error: "Errore di connessione al server" };
    }
    
}