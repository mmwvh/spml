from bayesian.factor_graph import *
from bayesian.bbn import *

dictionary_Pollution = {'high': 0.1, 'low': 0.9}
def f_Pollution(Pollution):
    return dictionary_Pollution[Pollution]

dictionary_Smoker = {'False': 0.7, 'True': 0.3}
def f_Smoker(Smoker):
    return dictionary_Smoker[Smoker]

dictionary_Cancer = {('high', 'False', 'False'): 0.98, ('low', 'False', 'False'): 0.999, ('low', 'True', 'True'): 0.03, ('high', 'True', 'False'): 0.95, ('low', 'True', 'False'): 0.97, ('low', 'False', 'True'): 0.001, ('high', 'False', 'True'): 0.02, ('high', 'True', 'True'): 0.05}
def f_Cancer(Pollution, Smoker, Cancer):
    return dictionary_Cancer[(Pollution, Smoker, Cancer)]

dictionary_Xray = {('True', 'negative'): 0.1, ('False', 'positive'): 0.2, ('True', 'positive'): 0.9, ('False', 'negative'): 0.8}
def f_Xray(Cancer, Xray):
    return dictionary_Xray[(Cancer, Xray)]

dictionary_Dyspnoea = {('False', 'False'): 0.7, ('False', 'True'): 0.3, ('True', 'True'): 0.65, ('True', 'False'): 0.35}
def f_Dyspnoea(Cancer, Dyspnoea):
    return dictionary_Dyspnoea[(Cancer, Dyspnoea)]

functions = [f_Pollution, f_Smoker, f_Cancer, f_Xray, f_Dyspnoea]
domains_dict = {'Xray': ['positive', 'negative'], 'Dyspnoea': ['True', 'False'], 'Smoker': ['True', 'False'], 'Cancer': ['True', 'False'], 'Pollution': ['low', 'high']}
def create_graph():
    g = build_graph(
        *functions,
        domains = domains_dict)
    g.name = 'cancer'
    return g
def create_bbn():
    g = build_bbn(
        *functions,
        domains = domains_dict)
    g.name = 'cancer'
    return g

