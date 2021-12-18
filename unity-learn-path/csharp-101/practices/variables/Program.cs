using System;

namespace variables
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WindowWidth = 130;
            Console.WindowHeight = 60;

            string mgr = "Type {0,8} |\t.NET {1,8} |\tSize = {2} \t| MIN = {3,30}\t| MAX = {4}";

            Console.Title = "Data types in C #";

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("\t\t\t\t\tNUMERIC (integer) TYPES:\n");
            Console.ForegroundColor = ConsoleColor.White;

            Console.WriteLine(string.Format(mgr, "byte", typeof(byte).Name, sizeof(byte), byte.MinValue, byte.MaxValue));
            Console.WriteLine(string.Format(mgr, "sbyte", typeof(sbyte).Name, sizeof(sbyte), sbyte.MinValue, sbyte.MaxValue));
            Console.WriteLine(string.Format(mgr, "short", typeof(short).Name, sizeof(short), short.MinValue, short.MaxValue));
            Console.WriteLine(string.Format(mgr, "ushort", typeof(ushort).Name, sizeof(ushort), ushort.MinValue, ushort.MaxValue));
            Console.WriteLine(string.Format(mgr, "int", typeof(int).Name, sizeof(int), int.MinValue, int.MaxValue));
            Console.WriteLine(string.Format(mgr, "uint", typeof(uint).Name, sizeof(uint), uint.MinValue, uint.MaxValue));
            Console.WriteLine(string.Format(mgr, "long", typeof(long).Name, sizeof(long), long.MinValue, long.MaxValue));
            Console.WriteLine(string.Format(mgr, "ulong", typeof(ulong).Name, sizeof(ulong), ulong.MinValue, ulong.MaxValue));

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("\n\t\t\t\t\tNUMERIC (floating point) TYPES:\n");
            Console.ForegroundColor = ConsoleColor.White;

            Console.WriteLine(string.Format(mgr, "float", typeof(float).Name, sizeof(float), float.MinValue, float.MaxValue));
            Console.WriteLine(string.Format(mgr, "double", typeof(double).Name, sizeof(double), double.MinValue, double.MaxValue));
            Console.WriteLine(string.Format(mgr, "decimal", typeof(decimal).Name, sizeof(decimal), decimal.MinValue, decimal.MaxValue));

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("\n\t\t\t\t\tSTRING TYPES:\n");
            Console.ForegroundColor = ConsoleColor.White;

            Console.WriteLine(string.Format(mgr, "char", typeof(char).Name, sizeof(char), char.MinValue, char.MaxValue));
            Console.WriteLine(string.Format(mgr, "string", typeof(string).Name, "N/A", "N/A", "N/A"));

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("\n\t\t\t\t\tLOGIC TYPES:\n");
            Console.ForegroundColor = ConsoleColor.White;

            Console.WriteLine(string.Format(mgr, "bool", typeof(bool).Name, sizeof(bool), bool.FalseString, bool.TrueString));

            Console.ForegroundColor = ConsoleColor.Green;
            Console.WriteLine("\n\t\t\t\t\tSPECIAL TYPES:\n");
            Console.ForegroundColor = ConsoleColor.White;

            Console.WriteLine(string.Format(mgr, "object", typeof(object).Name, "N/A", "N/A", "N/A"));
            Console.WriteLine(string.Format(mgr, "dynamic", "N/A", "N/A", "N/A", "N/A"));

            Console.Read();
            // thx to Psycho Develop
        }
    }
}
