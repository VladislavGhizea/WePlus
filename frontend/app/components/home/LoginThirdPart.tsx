import React from "react";
import { ThirdPartButton } from "./buttons";

const LoginThirdPart = () => {
  return (
    <div className="flex flex-col justify-center items-center">
      <ThirdPartButton text="Apple" />
      <div className="mt-[1.5rem]">
        <ThirdPartButton text="Google" />
      </div>
    </div>
  );
};

export default LoginThirdPart;
