import React from "react";
import { TextInput } from "../buttons";
interface Filter {
  name: string;
  onSubmit: () => void;
}

interface Props {
  filters: Filter[];
}
const Filters: React.FC<Props> = ({ filters }) => {
  return (
    <>
      {filters.map((filter, index) => (
        <form key={index} onSubmit={filter.onSubmit}>
          <TextInput text={filter.name} type={"text"} />
        </form>
      ))}
    </>
  );
};

export default Filters;
