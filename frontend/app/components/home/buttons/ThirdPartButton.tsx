import React from "react";
import { FaApple } from "react-icons/fa";
import { FcGoogle } from "react-icons/fc";

interface Props {
  text: string;
}

const ThirdPartButton: React.FC<Props> = ({ text }) => {
  const color = text === "Apple" ? "bg-black text-white" : "bg-white";
  return (
    <button
      className={`w-[23rem] h-[3rem] rounded-full flex items-center ${color}`}
    >
      {text === "Apple" ? (
        <FaApple className="w-[2rem] h-[2rem] mx-2" color="white" />
      ) : (
        <FcGoogle className="w-[2rem] h-[2rem] mx-2" />
      )}
      <p className="text-base flex-1 text-center">Continua con {text}</p>
    </button>
  );
};

export default ThirdPartButton;
