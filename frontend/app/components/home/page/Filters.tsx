import React from "react";
import { IconButton, TextInput } from "../buttons";
import Category from "./Category";
import { HiMagnifyingGlass, HiOutlinePlusSmall } from "react-icons/hi2";
interface Filter {
  name: string;
  onSubmit: () => void;
}

interface Props {
  filters: Filter[];
}
const Filters: React.FC<Props> = ({ filters }) => {
  const handleOrderClick = () => {
    //TODO
  }
  return (
    <>
      <div className="flex flex-row mt-[1rem]">
        {filters.map((filter, index) => (
          <form key={index} onSubmit={filter.onSubmit}>
            <TextInput
              width="w-[13rem]"
              classNameContainer="ml-[1rem]"
              text={filter.name}
              type={"text"}
            />
          </form>
        ))}
        <IconButton
          className="w-[4.5rem] h-[4.5rem] rounded-2xl bg-white flex justify-center items-center ml-[1rem]"
          icon={
            <HiOutlinePlusSmall className="w-[2rem] h-[2rem]" color="#9ca3af" />
          }
          onClick={() => {}}
        />
        <IconButton
          icon={<HiMagnifyingGlass className="w-[3rem] h-[3rem] ml-[1rem]" />}
          onClick={() => {}}
        />
      </div>
      <div>
        <Category
          icon={<div />}
          text="Ordina per"
          onClick={handleOrderClick}
          classNameContainer="justify-start"
        />
      </div>
    </>
  );
};

export default Filters;
