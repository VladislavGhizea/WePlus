import React from "react";
import { HiChevronDown } from "react-icons/hi2";
interface Props {
  icon: React.ReactNode;
  text: string;
  onClick: () => void;
}
const Category: React.FC<Props> = ({ icon, text }) => {
  return (
    <button className="flex justify-between items-center w-full p-2">
      <div className="flex flex-row justify-center items-center">
        {icon}
        <p className="ml-2 text-md justify-center items-center">{text}</p>
      </div>
      <HiChevronDown className="mr-2 h-6 w-6" />
    </button>
  );
};

export default Category;
