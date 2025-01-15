import React from "react";
import { ActionButton, TextInput } from "./buttons";

const Login = () => {
  return (
    <div>
      <form action="" method="get" className="flex flex-col mt-[3.5rem]">
        <div>
          <TextInput text="Username" type="text" />
        </div>
        <div className="mt-[2rem]">
          <TextInput text="Password" type="password" />
        </div>
        <div className="mt-[1rem] flex justify-center">
          <a href="#" className="text-[#3BA5F0]">
            credenziali dimenticate?
          </a>
        </div>
        <div className="mt-[2rem] flex flex-row">
          <ActionButton text="Accedi" />
          <div className="flex justify-center items-center">
            <p className="mx-[1.75rem] text-2xl">o</p>
          </div>
          <ActionButton text="Registrati" />
        </div>
      </form>
    </div>
  );
};

export default Login;
