import { InputSection } from "../";
const Content: React.FC<{
  values: { text: string; type: string; options?: string[] }[];
}> = ({ values }) => (
  <div className="grid grid-cols-2 grid-rows-1">
    <InputSection
      className="mr-[4rem] ml-[4rem]"
      inputs={values.slice(0, Math.floor(values.length / 2) + 1)}
    />
    <InputSection
      className="mr-[4rem] ml-[4rem]"
      inputs={values.slice(Math.floor(values.length / 2) + 1, values.length)}
    />
  </div>
);
export default Content;
